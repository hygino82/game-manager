import { useState } from "react";
import axios from "axios";
import { BASE_URL } from "../../RequestUrl";

export function ConsoleForm() {
    const [name, setName] = useState<string>("");
    const [company, setCompany] = useState<string>("");
    const [releaseDate, setReleaseDate] = useState<string>("2000-01-01");
    const [imageUrl, setImageUrl] = useState<string>("");

    function registerConsole() {
        const consoleData = {
            name,
            company,
            releaseDate,
            imageUrl
        };

        axios.post(`${BASE_URL}/console`, consoleData)
            .then(response => {
                console.log('Console registrado com sucesso:', response.data);
                clearFields();
            })
            .catch(error => {
                console.error('Erro ao registrar console:', error);
            });
    }

    function clearFields() {
        setName('');
        setCompany('');
        setImageUrl('');
        setReleaseDate('2000-01-01');
    }

    return (
        <div className="container">
            <label htmlFor="name">Nome</label>
            <input
                type="text"
                id="name"
                placeholder="Nome do console"
                value={name}
                onChange={(e) => setName(e.target.value)}
            /><br />
            <label htmlFor="company">Empresa</label>
            <input
                type="text"
                id="company"
                placeholder="Empresa"
                value={company}
                onChange={(e) => setCompany(e.target.value)}
            /><br />
            <label htmlFor="release-date">Lançamento</label>
            <input
                type="date"
                id="release-date"
                value={releaseDate}
                onChange={(e) => setReleaseDate(e.target.value)}
            /><br />
            <label htmlFor="img-url">Link da imagem</label>
            <input
                type="text"
                id="img-url"
                placeholder="Link da imagem"
                value={imageUrl}
                onChange={(e) => setImageUrl(e.target.value)}
            /><br />

            <input
                type="button"
                value="Adicionar"
                className="btn btn-primary"
                onClick={registerConsole}
            />
        </div>
    );
}
