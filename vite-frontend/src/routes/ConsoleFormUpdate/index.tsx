import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { ConsoleType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";
import './styles.css';

export default function ConsoleFormUpdate() {
  const { id } = useParams();
  const [atualizar, setAtualizar] = useState<boolean>(true);
  const [platform, setPlatform] = useState<ConsoleType>({
    name: '',
    imgUrl: '',
    releaseYear: 0
  })

  function handleChange(event: any) {
    setPlatform({ ...platform, [event.target.name]: event.target.value });
  }

  useEffect(() => {
    axios.get(`${BASE_URL}/console/${id}`).then((result) => {
      const valores: ConsoleType = result.data as ConsoleType;
      console.log(valores);
      setPlatform(valores);
    });
  }, []);


  function handleSubmit(event: any) {
    event.preventDefault();
    console.log(`Modificando objeto com o Id: ${platform.id}`);
    axios.put(`${BASE_URL}/console/${id}`, platform).then(function () {
      setAtualizar(!atualizar);
    }).catch(() => alert('Erro ao atualizar o console!'))

    alert('Alterações realizadas com sucesso');
  }

  return (
    <>
      <h3>Alterando dados do console</h3>
      <div className="container">
        <form onSubmit={handleSubmit}>
          <div className="container">
            <label className="form-label">Nome do Console</label>
            <input
              type="text"
              value={platform.name}
              name="name"
              className="form-control"
              onChange={handleChange}
            />
          </div>
          <div className="container">
            <label className="form-label">Link da imagem</label>
            <input
              type="text"
              value={platform.imgUrl}
              name="imgUrl"
              className="form-control"
              onChange={handleChange}
            />
          </div>
          <div className="container">
            <label className="form-label">Ano de lançamento</label>
            <input
              type="number"
              value={platform.releaseYear}
              name="releaseYear"
              className="form-control"
              onChange={handleChange}
            />
          </div>
          <input type="submit" value="Alterar" className="btn btn-success" />
        </form>
      </div>
    </>
  );
}
