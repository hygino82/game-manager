import { useEffect, useState } from "react";
import { Game, GamePageType } from "../../types/custom-types";
import { FiInfo, FiTrash2, FiEdit } from "react-icons/fi";
import axios from "axios";
import { BASE_URL } from "../../utils/request";

function GameTable() {
  const [pageNumber, setPageNumber] = useState(0);

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

  useEffect(() => {
    axios
      .get(`${BASE_URL}/game?size=12&page=${pageNumber}`)
      .then((response) => {
        const data = response.data as GamePageType;
        setPage(data);
      });
  }, [pageNumber]);

  const handlePageChange = (newPageNumber: number) => {
    setPageNumber(newPageNumber);
  };
  return (
    <table className="table table-striped">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">Name</th>
          <th scope="col">Console</th>
          <th scope="col">Release date</th>
          <th scope="col">Actions</th>
        </tr>
      </thead>
      <tbody>
        {page.content.map((game) => (
          <tr key={game.id}>
            <th scope="col">{game.id}</th>
            <th scope="col">{game.name}</th>
            <th scope="col">{game.consoleName}</th>
            <th scope="col">{game.releaseYear}</th>
            <th scope="col">
              {" "}
              <FiInfo /> <FiEdit /> <FiTrash2 />
            </th>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default GameTable;
