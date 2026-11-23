const API_PERSONAGENS = '/api/personagens';
const API_ITENS = '/api/itens';

document.addEventListener('DOMContentLoaded', () => {
    carregarPersonagens();
    carregarItens();
});

// ================= PERSONAGENS =================

async function carregarPersonagens() {
    const res = await fetch(API_PERSONAGENS);
    const lista = await res.json();
    const tbody = document.getElementById('tabela-personagens');
    tbody.innerHTML = '';

    lista.forEach(p => {
        tbody.innerHTML += `
            <tr>
                <td>${p.id}</td>
                <td>${p.nome}</td>
                <td>${p.raca}</td>
                <td>${p.papel}</td>
                <td>❤️ ${p.coracoes}</td>
                <td>
                    <button class="btn-editar" onclick="editarPersonagem(${p.id}, '${p.nome}', '${p.raca}', '${p.papel}', ${p.coracoes})">Editar</button>
                    <button class="btn-excluir" onclick="deletarPersonagem(${p.id})">Excluir</button>
                </td>
            </tr>
        `;
    });
}

document.getElementById('form-personagem').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('personagem-id').value;
    const dados = {
        nome: document.getElementById('personagem-nome').value,
        raca: document.getElementById('personagem-raca').value,
        papel: document.getElementById('personagem-papel').value,
        coracoes: parseInt(document.getElementById('personagem-coracoes').value)
    };

    if (id) {
        await fetch(`${API_PERSONAGENS}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });
    } else {
        await fetch(API_PERSONAGENS, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });
    }

    limparFormPersonagem();
    carregarPersonagens();
});

function editarPersonagem(id, nome, raca, papel, coracoes) {
    document.getElementById('personagem-id').value = id;
    document.getElementById('personagem-nome').value = nome;
    document.getElementById('personagem-raca').value = raca;
    document.getElementById('personagem-papel').value = papel;
    document.getElementById('personagem-coracoes').value = coracoes;
}

async function deletarPersonagem(id) {
    await fetch(`${API_PERSONAGENS}/${id}`, { method: 'DELETE' });
    carregarPersonagens();
}

function limparFormPersonagem() {
    document.getElementById('form-personagem').reset();
    document.getElementById('personagem-id').value = '';
}

// ================= ITENS =================

async function carregarItens() {
    const res = await fetch(API_ITENS);
    const lista = await res.json();
    const tbody = document.getElementById('tabela-itens');
    tbody.innerHTML = '';

    lista.forEach(item => {
        tbody.innerHTML += `
            <tr>
                <td>${item.id}</td>
                <td>${item.nome}</td>
                <td>${item.tipo}</td>
                <td>⚔️ ${item.poder}</td>
                <td>${item.raridade}</td>
                <td>
                    <button class="btn-editar" onclick="editarItem(${item.id}, '${item.nome}', '${item.tipo}', ${item.poder}, '${item.raridade}')">Editar</button>
                    <button class="btn-excluir" onclick="deletarItem(${item.id})">Excluir</button>
                </td>
            </tr>
        `;
    });
}

document.getElementById('form-item').addEventListener('submit', async (e) => {
    e.preventDefault();
    const id = document.getElementById('item-id').value;
    const dados = {
        nome: document.getElementById('item-nome').value,
        tipo: document.getElementById('item-tipo').value,
        poder: parseInt(document.getElementById('item-poder').value),
        raridade: document.getElementById('item-raridade').value
    };

    if (id) {
        await fetch(`${API_ITENS}/${id}`, {
            method: 'PUT',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });
    } else {
        await fetch(API_ITENS, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });
    }

    limparFormItem();
    carregarItens();
});

function editarItem(id, nome, tipo, poder, raridade) {
    document.getElementById('item-id').value = id;
    document.getElementById('item-nome').value = nome;
    document.getElementById('item-tipo').value = tipo;
    document.getElementById('item-poder').value = poder;
    document.getElementById('item-raridade').value = raridade;
}

async function deletarItem(id) {
    await fetch(`${API_ITENS}/${id}`, { method: 'DELETE' });
    carregarItens();
}

function limparFormItem() {
    document.getElementById('form-item').reset();
    document.getElementById('item-id').value = '';
}
