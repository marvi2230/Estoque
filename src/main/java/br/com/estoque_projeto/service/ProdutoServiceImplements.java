package br.com.estoque_projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.estoque_projeto.entity.Produto;
import br.com.estoque_projeto.repository.ProdutoRepository;

@Service
public class ProdutoServiceImplements implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public List<Produto> getAllProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public void save(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public Produto getById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteViaId(long id) {
        produtoRepository.deleteById(id);
    }
}
