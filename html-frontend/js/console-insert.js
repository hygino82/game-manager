let txtNome = document.getElementById('nome');
let txtEmpresa = document.getElementById('empresa');
let txtLinkImagem = document.getElementById('link-imagem');
let btnAdicionar = document.getElementById('btn-adicionar');
let btnLimpar = document.getElementById('btn-limpar');
let btnListar = document.getElementById('btn-listar');
let dataLancamento = document.getElementById('data-lancamento');

let tabela = document.getElementById('tabela');
const BASE_URL = 'http://localhost:8080/api/v1';

function limparDados() {
    txtNome.value = '';
    txtEmpresa.value = '';
    txtLinkImagem.value = '';
    txtNome.value = '';
    dataLancamento.value = '2012-07-18';
}

btnLimpar.addEventListener('click', limparDados, false);

function listarDados(e) {
    e.preventDefault();
    tabela.innerHTML = '';
    fetch(`${BASE_URL}/console`)
        .then(response => response.json())
        .then(data => {
            data.content.forEach(obj => {
                tabela.innerHTML += `
            <tr>
                <th scope="row">${obj.name}</th>
                <td>${obj.company}</td>
                <td>${obj.releaseDate}</td>
                <td>Info</td>
            </tr>
            `;
            })
        })
        .catch(err => console.log(err));
}

btnListar.addEventListener('click', listarDados);

function adicionar() {
    const gameConsole = {
        name: txtNome.value,
        company: txtEmpresa.value,
        releaseDate: dataLancamento.value,
        imageUrl: txtLinkImagem.value
    }

    const targetUrl = `${BASE_URL}/console`;

    fetch(targetUrl, {
        method: 'POST', // Define o método HTTP como POST
        headers: {
            'Content-Type': 'application/json' // Define o tipo de conteúdo como JSON
        },
        body: JSON.stringify(gameConsole) // Converte o objeto JavaScript em uma string JSON
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json(); // Converte a resposta em JSON
        })
        .then(data => {
            alert('Success:', data); // Manipula a resposta da requisição
        })
        .catch(error => {
            console.error('Error:', error); // Manipula erros
        });
}

btnAdicionar.addEventListener('click', adicionar, false);
