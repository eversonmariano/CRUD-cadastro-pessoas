package teste.java.com.everson.crud.ejb;



import com.everson.crud.dao.EnderecoDAO;
import com.everson.crud.model.Endereco;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static javax.management.Query.times;
import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class EnderecoBeanTest {

    @InjectMocks
    private EnderecoBean enderecoBean;

    @Mock
    private EnderecoDAO enderecoDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSave() {
        Endereco endereco = new Endereco();
        endereco.setLogradouro());
        enderecoBean.save(endereco);
        verify(enderecoDAO, times(1)).save(endereco);
    }

    @Test
    public void testUpdate() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setLogradouro();
        enderecoBean.update(endereco);
        verify(enderecoDAO, times(1)).update(endereco);
    }

    @Test
    public void testDelete() {
        enderecoBean.delete(1L);
        verify(enderecoDAO, times(1)).delete(1L);
    }

    @Test
    public void testFindById() {
        Endereco endereco = new Endereco();
        when(enderecoDAO.findById(1L)).thenReturn(endereco);
        Endereco result = enderecoBean.findById(1L);
        assertEquals(endereco, result);
    }

    @Test
    public void testFindAll() {
        List<Endereco> enderecos = Arrays.asList(new Endereco(), new Endereco());
        when(enderecoDAO.findAll()).thenReturn(enderecos);
        List<Endereco> result = enderecoBean.findAll();
        assertEquals(enderecos, result);
    }
}

