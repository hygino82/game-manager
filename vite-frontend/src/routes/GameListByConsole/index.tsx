import axios from "axios";
import { useEffect, useState } from "react";
import { FiEdit, FiInfo, FiTrash2 } from "react-icons/fi";
import { ConsoleType, GamePageType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";
import { useParams } from "react-router-dom";

export default function GameListByConsole() {
  const { id } = useParams();
  const [pageNumber, setPageNumber] = useState(0);
  const [atualizar, setAtualizar] = useState<boolean>(true);
  const [consoleName, setConsoleName] = useState<string>('');

  const [page, setPage] = useState<GamePageType>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 12,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
  });

  function handleDelete(id: string | undefined) {
    axios
      .delete(`${BASE_URL}/game/${id}`)
      .then(() => setAtualizar(!atualizar))
      .catch(() => {
        alert('Erro ao excluir o jogo!')
      });
  }

  useEffect(() => {
    axios
      .get(`${BASE_URL}/game/console/${id}?size=12&page=${pageNumber}`)
      .then((response) => {
        const data = response.data as GamePageType;
        setPage(data);
      });
    axios
      .get(`${BASE_URL}/console/${id}`)
      .then((response) => {
        const data = response.data as ConsoleType;
        setConsoleName(data.name);
      });

  }, [pageNumber, atualizar, consoleName]);

  const handlePageChange = (newPageNumber: number) => {
    setPageNumber(newPageNumber);
  };

  if (page.empty) {
    return (
      <h3>Não existem jogos cadastrados do console {consoleName}</h3>
    )
  }

  return (
    <>
      <h3>{consoleName}</h3>

      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">Name</th>
            <th scope="col">Release date</th>
            <th scope="col">Actions</th>
          </tr>
        </thead>
        <tbody>
          {page.content.map((game) => (
            <tr key={game.id}>
              <th scope="col">{game.name}</th>
              <th scope="col">{game.releaseYear}</th>
              <th scope="col">
                <button
                  type="submit"
                  onClick={() => handleDelete(game.id)}
                  className="btn btn-danger"
                >
                  <FiTrash2 />
                </button>
                <FiInfo /> <FiEdit />
              </th>
            </tr>
          ))}
        </tbody>
      </table>
    </>
  );

}
