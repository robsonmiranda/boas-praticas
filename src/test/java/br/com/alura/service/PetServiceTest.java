package br.com.alura.service;

import br.com.alura.client.ClientHttpConfiguration;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class PetServiceTest {

    private ClientHttpConfiguration client = mock(ClientHttpConfiguration.class);
    private PetService petService = new PetService(client);
    private HttpResponse<String> response = mock(HttpResponse.class);

    @Test
    public void deveVerificarSeDispararRequisicaoPostSeraChamado() throws IOException, InterruptedException {
        // cria arquivo CSV temporário
        Path tempFile = Files.createTempFile("pets", ".csv");
        Files.writeString(tempFile, "cachorro,Bidu,Vira-lata,5,preto,10.5\n");

        // simula entrada do usuário (id do abrigo + nome do arquivo)
        String userInput = String.format("abrigo123%s%s%s",
                System.lineSeparator(), tempFile.toString(), System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        // mocks
        when(response.statusCode()).thenReturn(200);
        when(client.dispararRequisicaoPost(anyString(), any())).thenReturn(response);

        // executa
        petService.importarPets();

        // verifica
        verify(client, atLeastOnce()).dispararRequisicaoPost(anyString(), any());
    }
}