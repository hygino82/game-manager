import axios from "axios";
import { useEffect, useState } from "react";
import { FiEdit, FiInfo, FiList, FiTrash2 } from "react-icons/fi";
import { Link } from "react-router-dom";
import { ConsolePageType, ConsoleType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";

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

  function handleGameListPage(id: string | undefined) {

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
                <Link to={`/console/${item.id}`} className="btn btn-info"><FiInfo /></Link>
                &nbsp;&nbsp;
                <Link to={`/edit/console/${item.id}`} className="btn btn-warning"><FiEdit /></Link>
                &nbsp;&nbsp;
                <button
                  type="submit"
                  onClick={() => handleDelete(item.id)}
                  className="btn btn-danger"
                >
                  <FiTrash2 />
                </button>
                &nbsp;&nbsp;
                <Link to={`/game/console/${item.id}`} className="btn btn-dark"><FiList /></Link>
              </td>
            </tr>
          );
        })}

      </tbody>
    </table>
  );
}
