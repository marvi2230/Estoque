package br.com.estoque_projeto.service;

import java.util.List;
import br.com.estoque_projeto.entity.Produto;

public interface ProdutoService {
    List<Produto> getAllProduto();
    void save(Produto produto);
    Produto getById(Long id);
    void deleteViaId(long id);
}


