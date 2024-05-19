package teste.java.com.everson.crud.ejb;



import com.everson.crud.dao.PessoaDAO;
import com.everson.crud.model.Pessoa;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PessoaBeanTest {

    @InjectMocks
    private PessoaBean pessoaBean;

    @Mock
    private PessoaDAO pessoaDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João");
        pessoaBean.save(pessoa);
        verify(pessoaDAO, times(1)).save(pessoa);
    }

    @Test
    public void testUpdate() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");
        pessoaBean.update(pessoa);
        verify(pessoaDAO, times(1)).update(pessoa);
    }

    @Test
    public void testDelete() {
        pessoaBean.delete(1L);
        verify(pessoaDAO, times(1)).delete(1L);
    }

    @Test
    public void testFindById() {
        Pessoa pessoa = new Pessoa();
        when(pessoaDAO.findById(1L)).thenReturn(pessoa);
        Pessoa result = pessoaBean.findById(1L);
        assertEquals(pessoa, result);
    }

    @Test
    public void testFindAll() {
        List<Pessoa> pessoas = Arrays.asList(new Pessoa(), new Pessoa());
        when(pessoaDAO.findAll()).thenReturn(pessoas);
        List<Pessoa> result = pessoaBean.findAll();
        assertEquals(pessoas, result);
    }
}
