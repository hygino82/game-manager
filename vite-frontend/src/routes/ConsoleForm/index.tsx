import axios from "axios";
import { useEffect, useState } from "react";
import { ConsolePageType, ConsoleType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";
import './styles.css';

export default function ConsoleForm() {

  const [consolePage, setConsolePage] = useState<ConsolePageType>();

  const [atualizar, setAtualizar] = useState<boolean>(true);

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
        //setAtualizar(result);
        setAtualizar(!atualizar);
      });
    } else {
      console.log(`Registro criado`);
      axios.post(`${BASE_URL}/console`, platform).then((result) => {
        console.log(result.data);
        setAtualizar(!atualizar);
        //setAtualizar(result);
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
    </>
  );
}
