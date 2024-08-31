import axios from "axios";
import { useEffect, useState } from "react";
import { FiEdit, FiInfo, FiTrash2 } from "react-icons/fi";
import { ConsolePageType, ConsoleType } from "../../types/custom-types";
import { formatDate } from "../../utils/formatter";
import { BASE_URL } from "../../utils/request";

export default function ConsoleForm() {
  const [name, setName] = useState("");
  const [imageUrl, setImageUrl] = useState("");
  const [company, setCompany] = useState("");
  const [releaseDate, setReleaseDate] = useState("2010-11-14");

  const [consolePage, setConsolePage] = useState<ConsolePageType>();
  const [atualizar, setAtualizar] = useState<boolean>(true);

  const [platform, setPlatform] = useState<ConsoleType>({
    name,
    imageUrl,
    releaseDate,
    company,
  });

  function limparCampos() {
    setName("");
    setCompany("");
    setImageUrl("");
    setReleaseDate("2010-11-14");
  }

  function handleChangeName(event: any) {
    setName(event.target.value);
  }

  function handleChangeCompany(event: any) {
    setCompany(event.target.value);
  }

  function handleChangeImage(event: any) {
    setImageUrl(event.target.value);
  }

  function handleChangeDate(event: any) {
    const date = event.target.value;
    setReleaseDate(date);
  }

  function handleSubmit(event: any) {
    event.preventDefault();

    const updatedPlatform = {
      name,
      releaseDate,
      company,
      imageUrl,
      id: platform.id,
    };

    if (platform.id) {
      console.log(`Modificando objeto com o Id: ${platform.id}`);
      axios
        .put(`${BASE_URL}/console/${platform.id}`, updatedPlatform)
        .then((result) => {
          setPlatform(result.data);
          setAtualizar(!atualizar);
        });
    } else {
      console.log(`Registro criado`);
      axios.post(`${BASE_URL}/console?sort=name`, updatedPlatform).then((result) => {
        setPlatform(result.data);
        setAtualizar(!atualizar);
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
    const confirmacao = confirm("Tem certeza de que deseja excluir este item?");
    if (confirmacao) {
      axios
        .delete(`${BASE_URL}/console/${id}`)
        .then(() => setAtualizar(!atualizar));
    }
  }

  function handleAlterar(item: ConsoleType): void {
    setPlatform(item);
    setName(item.name);
    setCompany(item.company);
    setImageUrl(item.imageUrl || "");
  }

  function handleInfo(id: string | undefined): void {
    alert(`${id} não implementado!`);
  }

  return (
    <div className="container">
      <form onSubmit={handleSubmit}>
        <div className="container">
          <label className="form-label">Nome do Console</label>
          <input
            type="text"
            value={name}
            name="name"
            className="form-control"
            onChange={handleChangeName}
          />
        </div>
        <div className="container">
          <label className="form-label">Empresa</label>
          <input
            type="text"
            value={company}
            name="company"
            className="form-control"
            onChange={handleChangeCompany}
          />
        </div>
        <div className="container">
          <label className="form-label">Imagem URL</label>
          <input
            type="text"
            value={imageUrl}
            name="imageUrl"
            className="form-control"
            onChange={handleChangeImage}
          />
        </div>

        <div className="container">
          <label className="form-label">Data de lançamento</label>
          <input
            type="date"
            value={releaseDate}
            name="releaseDate"
            className="form-control"
            onChange={handleChangeDate}
          />
        </div>
        <input type="submit" value="Salvar" className="btn btn-dark" />
      </form>
      <hr />
      <hr />
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th scope="col">Nome</th>
            <th scope="col">Lançamento</th>
            <th scope="col">Ações</th>
          </tr>
        </thead>
        <tbody>
          {consolePage?.content.map((item) => {
            return (
              <tr key={item.id}>
                <td>{item.name}</td>
                <td>{formatDate(item.releaseDate)}</td>
                <td>
                  <button
                    type="button"
                    onClick={() => handleAlterar(item)}
                    className="btn btn-primary"
                  >
                    <FiEdit /> Alterar
                  </button>
                  &nbsp;&nbsp;
                  <button
                    type="button"
                    onClick={() => handleDelete(item.id)}
                    className="btn btn-danger"
                  >
                    <FiTrash2 /> Excluir
                  </button>
                  &nbsp;&nbsp;
                  <a href={`http://localhost:5173/console/${item.id}`}>
                    <button
                      type="button"
                      //onClick={() => handleInfo(item.id)}
                      className="btn btn-success"
                    >
                      <FiInfo /> Informação
                    </button>
                  </a>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
}
