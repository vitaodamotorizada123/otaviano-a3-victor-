import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidadorUsuarioTest {

    private ValidadorUsuario validador;

    @BeforeEach
    void setUp() {
        validador = new ValidadorUsuario();
    }

    // ==========================
    // Testes de Nome de Usuário
    // ==========================

    @Test
    void testNomeUsuarioValido() {
        assertTrue(validador.validarNomeUsuario("Victor"));
        assertTrue(validador.validarNomeUsuario("Usuario123"));
    }

    @Test
    void testNomeUsuarioMuitoCurto() {
        assertFalse(validador.validarNomeUsuario("AB"));
        assertFalse(validador.validarNomeUsuario(""));
    }

    @Test
    void testNomeUsuarioMuitoLongo() {
        assertFalse(
            validador.validarNomeUsuario("abcdefghijklmnopqrstuvwxyz")
        );
    }

    @Test
    void testNomeUsuarioNulo() {
        assertFalse(validador.validarNomeUsuario(null));
    }

    // ==========================
    // Testes de E-mail
    // ==========================

    @Test
    void testEmailValido() {
        assertTrue(validador.validarEmail("usuario@email.com"));
        assertTrue(validador.validarEmail("teste.silva@empresa.com.br"));
    }

    @Test
    void testEmailSemArroba() {
        assertFalse(validador.validarEmail("usuarioemail.com"));
    }

    @Test
    void testEmailSemDominio() {
        assertFalse(validador.validarEmail("usuario@"));
        assertFalse(validador.validarEmail("usuario@email"));
    }

    @Test
    void testEmailNulo() {
        assertFalse(validador.validarEmail(null));
    }

    // ==========================
    // Testes de Senha
    // ==========================

    @Test
    void testSenhaValida() {
        assertTrue(validador.validarSenha("Senha123"));
        assertTrue(validador.validarSenha("Teste2024"));
    }

    @Test
    void testSenhaMuitoCurta() {
        assertFalse(validador.validarSenha("Abc123"));
    }

    @Test
    void testSenhaSemNumeros() {
        assertFalse(validador.validarSenha("SenhaTeste"));
    }

    @Test
    void testSenhaSemLetras() {
        assertFalse(validador.validarSenha("12345678"));
    }

    @Test
    void testSenhaNula() {
        assertFalse(validador.validarSenha(null));
    }
}