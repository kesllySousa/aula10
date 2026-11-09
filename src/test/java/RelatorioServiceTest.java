import org.example.RelatorioService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RelatorioServiceTest {

    @Test
    void deveGerarRelatorioCompleto() {
        RelatorioService service = new RelatorioService();
        String resultado = service.gerarRelatorio(1);
        assertEquals("Relatório Completo", resultado);
    }

    @Test
    void deveGerarRelatorioResumido() {
        RelatorioService service = new RelatorioService();
        String resultado = service.gerarRelatorio(2);
        assertEquals("Relatório Resumido", resultado);
    }

    @Test
    void deveGerarRelatorioPadrao() {
        RelatorioService service = new RelatorioService();
        String resultado = service.gerarRelatorio(3);
        assertEquals("Relatório Padrão", resultado);
    }
}