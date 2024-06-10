package br.com.estoque_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.estoque_projeto.entity.Produto;
import br.com.estoque_projeto.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllProduto() {
        return produtoService.getAllProduto();
    }
// método para salvar
    @PostMapping("/save")
    public void save(@RequestBody Produto produto) {
        produtoService.save(produto);
    }

    @GetMapping("/{id}")
    public Produto getById(@PathVariable Long id) {
        return produtoService.getById(id);
    }
    // Método PUT para atualizar um produto existente
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Produto produto) {
        // Primeiro, verifique se o produto com o ID especificado existe no banco de dados
        Produto existingProduto = produtoService.getById(id);
        
        if (existingProduto != null) {
            // Atualiza os campos do produto existente com os novos valores recebidos
            existingProduto.setName(produto.getName());
            existingProduto.setPreco(produto.getPreco());
            existingProduto.setDescricao(produto.getDescricao());
            existingProduto.setQuantidade(produto.getQuantidade());
            existingProduto.setUrlImagem(produto.getUrlImagem());
            
            
            // Salva o produto atualizado no banco de dados
            produtoService.save(existingProduto);
        } else {
            // Se o produto com o ID especificado não existe, pode lançar uma exceção ou retornar um status de erro
            // Neste exemplo, vamos lançar uma exceção, mas você pode tratar de acordo com sua aplicação
            throw new RuntimeException("Produto não encontrado com id: " + id);
        }
    }
// função para apagar o produto
    @DeleteMapping("/{id}")
    public void deleteViaId(@PathVariable long id) {
        produtoService.deleteViaId(id);
    }
}
