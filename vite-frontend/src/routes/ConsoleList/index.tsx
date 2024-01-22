import { useEffect, useState } from "react";
import { BASE_URL } from "../../utils/request";
import { ConsolePageType, ConsoleType } from "../../types/custom-types";
import axios from "axios";
import { Link } from "react-router-dom";

export default function ConsoleList() {
  const [consolePage, setConsolePage] = useState<ConsolePageType>();

  const [atualizar, setAtualizar] = useState<boolean>(true);

  const [platform, setPlatform] = useState<ConsoleType>({
    name: '',
    imgUrl: '',
    releaseYear: 0
  })

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
      .then(() => setAtualizar(!atualizar))
      .catch(() => alert('Não é possível remover um console com jogos vinculados!'));
  }

  return (
    <table className="table table-striped">
      <thead>
        <tr>
          <th scope="col">Nome</th>
          <th scope="col">Lançamento</th>
          <th scope="col">Ações</th>
        </tr>
      </thead>
      <tbody>
        {consolePage?.content.map(item => {
          return (
            <tr key={item.id}>
              <td>{item.name}</td>
              <td>{item.releaseYear}</td>
              <td>
                <Link to={`/console/${item.id}`} className="btn btn-success">Info</Link>
                &nbsp;&nbsp;
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
  );
}
