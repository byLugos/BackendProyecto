package com.example.demo.domain.service;

import com.example.demo.domain.exception.ValidationException;
import com.example.demo.domain.models.Usuario;
import com.example.demo.domain.ports.out.usuario.UsuarioOut;
import com.example.demo.infraestructure.auth.JwtUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioOut usuarioOut;
    private final JwtUtil jwtUtil;

    public AuthService(UsuarioOut usuarioOut, JwtUtil jwtUtil) {
        this.usuarioOut = usuarioOut;
        this.jwtUtil = jwtUtil;
    }

    public String login(String email, String password) {
        // Buscar usuario por email usando el puerto
        Usuario usuario = usuarioOut.findByEmail(email)
                .orElseThrow(() -> new ValidationException("Usuario no encontrado"));

        // Comparar contraseñas directamente
        if (!usuario.getPassword().equals(password)) {
            throw new ValidationException("Contraseña incorrecta");
        }

        // Generar y devolver token JWT
        return jwtUtil.generateToken(usuario.getEmail());
    }
}
