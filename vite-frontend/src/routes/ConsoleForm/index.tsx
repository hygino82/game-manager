import axios from "axios";
import { useEffect, useState } from "react";
import { ConsolePageType, ConsoleType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";
import './styles.css';

export default function ConsoleForm() {

    const [consolePage, setConsolePage] = useState<ConsolePageType>();

    const [atualizar, setAtualizar] = useState<any>();

    const [platform, setPlatform] = useState<ConsoleType>({
        name: '',
        imgUrl: '',
        releaseYear: 0
    })

    function limparCampos() {
        setPlatform({
            name: '',
            imgUrl: '',
            releaseYear: 0,
            id: ''
        });
    }

    function handleChange(event: any) {
        setPlatform({ ...platform, [event.target.name]: event.target.value });
    }

    function handleSubmit(event: any) {
        event.preventDefault();
        if (platform.id) {
            console.log(`Modificando objeto com o Id: ${platform.id}`);
            axios.put(`${BASE_URL}/console/${platform.id}`, platform).then((result) => {
                setAtualizar(result);
            });
        } else {
            console.log(`Registro criado`);
            axios.post(`${BASE_URL}/console`, platform).then((result) => {
                setAtualizar(result);
            });
        }
        limparCampos();
    }

    useEffect(() => {
        buscarTodos();
    }, [atualizar]);

    function buscarTodos() {
        axios.get(`${BASE_URL}/console`).then((result) => {
            const valores: ConsolePageType = result.data;
            setConsolePage(valores);
        });
    }

    function handleDelete(id: string | undefined) {
        axios
            .delete(`${BASE_URL}/console/${id}`)
            .then(() => setAtualizar(''));
    }

    return (
        <>
            <div className="container">
                <form onSubmit={handleSubmit}>
                    <div className="container">
                        <label className="form-label">Nome do Console</label>
                        <input
                            type="text"
                            value={platform.name || ""}
                            name="name"
                            className="form-control"
                            onChange={handleChange}
                        />
                    </div>
                    <div className="container">
                        <label className="form-label">Link da imagem</label>
                        <input
                            type="text"
                            value={platform.imgUrl || ""}
                            name="imgUrl"
                            className="form-control"
                            onChange={handleChange}
                        />
                    </div>
                    <div className="container">
                        <label className="form-label">Ano de lançamento</label>
                        <input
                            type="number"
                            value={platform.releaseYear || ""}
                            name="releaseYear"
                            className="form-control"
                            onChange={handleChange}
                        />
                    </div>
                    <input type="submit" value="Cadastrar" className="btn btn-success" />
                </form>
            </div>
            <hr />
            <hr />
            <table className="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Nome</th>
                        <th scope="col">Link da imagem</th>
                        <th scope="col">Lançamento</th>
                        <th scope="col">Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {consolePage?.content.map(item => {
                        return (
                            <tr key={item.id}>
                                <th scope="row">{item.id}</th>
                                <td>{item.name}</td>
                                <td>{item.imgUrl}</td>
                                <td>{item.releaseYear}</td>
                                <td>
                                    <button
                                        type="submit"
                                        onClick={() => setPlatform(item)}
                                        className="btn btn-primary"
                                    >
                                        Alterar
                                    </button>&nbsp;&nbsp;
                                    <button
                                        type="submit"
                                        onClick={() => handleDelete(item.id)}
                                        className="btn btn-danger"
                                    >
                                        Excluir
                                    </button>
                                </td>
                            </tr>
                        );
                    })}

                </tbody>
            </table>
        </>
    );
}
