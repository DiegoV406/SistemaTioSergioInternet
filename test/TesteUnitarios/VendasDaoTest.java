
package TesteUnitarios;

import br.com.sistemaInternetTeste.dao.VendasDao;
import br.com.sistemaInternetTeste.model.Vendas;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author D_Die
 */
public class VendasDaoTest {
    
    public VendasDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        vendasDao = new VendasDao();
        VendasDao.listar().clear();
    }
    
    @After
    public void tearDown() {
    }

    private VendasDao vendasDao;
    
    @Test
    public void testAtualizarTotalGeral() {
        
        Vendas venda1 = new Vendas("Produto A", 2, "10/12/2025", 10.0); // 20
        Vendas venda2 = new Vendas("Produto B", 3, "10/12/2025", 5.0);  // 15

        vendasDao.adicionar(venda1);
        vendasDao.adicionar(venda2);

        
        double totalGeral = vendasDao.atualizarTotalGeral();

        
        assertEquals(35.0, totalGeral, 0.001);
    }
}
