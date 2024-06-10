document.addEventListener('DOMContentLoaded', function() {
    var produtoForm = document.getElementById('produtoForm');
    if (produtoForm) {
        produtoForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Evita o comportamento padrão de submissão do formulário

            var name = document.getElementById('nome');
            var descricao = document.getElementById('descricao');
            var quantidade = document.getElementById('quantidade');
            var preco = document.getElementById('preco');
            var urlImagem = document.getElementById('urlImagem');

            // Verifica se todos os campos foram encontrados antes de acessar seus valores
            if (name && descricao && quantidade && preco && urlImagem) {
                var produto = {
                    name: name.value,
                    descricao: descricao.value,
                    quantidade: parseInt(quantidade.value),
                    preco: parseFloat(preco.value),
                    urlImagem: urlImagem.value
                };

                fetch('/api/produtos/save', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(produto)
                })
                .then(response => {
                    if (response.ok) {
                        Swal.fire({
                            icon: 'success',
                            title: 'Produto salvo com sucesso!',
                            showConfirmButton: false,
                            timer: 1500
                        }).then(() => {
                            window.location.reload(); // Recarrega a página após o sucesso
                        });
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Erro ao salvar produto!',
                            text: 'Por favor, tente novamente.',
                            showConfirmButton: true
                        });
                    }
                })
                .catch(error => {
                    console.error('Erro ao enviar dados para o servidor:', error);
                    Swal.fire({
                        icon: 'error',
                        title: 'Erro ao salvar produto!',
                        text: 'Por favor, tente novamente.',
                        showConfirmButton: true
                    });
                });
            } else {
                console.error('Um ou mais elementos do formulário não foram encontrados.');
                Swal.fire({
                    icon: 'error',
                    title: 'Erro interno!',
                    text: 'Por favor, recarregue a página e tente novamente.',
                    showConfirmButton: true
                });
            }
        });
    } else {
        console.error('Formulário não encontrado.');
        Swal.fire({
            icon: 'error',
            title: 'Erro interno!',
            text: 'Por favor, recarregue a página e tente novamente.',
            showConfirmButton: true
        });
    }
});
