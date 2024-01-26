import { useEffect, useState } from "react";
import { BASE_URL } from "../../utils/request";
import { useParams } from "react-router-dom";
import { GameType } from "../../types/custom-types";
import axios from "axios";

export default function GameCardInfo() {
  //const [atualizar, setAtualizar] = useState<boolean>(true);
  const { id } = useParams();
  const [game, setGame] = useState<GameType>({
    id: '',
    name: '',
    consoleName: '',
    consoleId: '',
    imageUrl: '',
    personalCode: '',
    releaseYear: 0
  })

  useEffect(() => {
    axios
      .get(`${BASE_URL}/game/${id}`)
      .then((response) => {
        const data = response.data as GameType;
        setGame(data);
      }).catch(error => console.log('Erro na solicitação'));
  }, []);


  return (
    <div className="card" id="game-card" key={game.id}>
      <img className="card-img-top" src={game.imageUrl} alt="" />
      <div className="card-body">
        <h5 className="card-title">{game.name}</h5>
        <p className="card-text">{game.consoleName}</p>
        <p className="card-text">{game.releaseYear}</p>
        <p className="card-text">{(game.personalCode) == undefined ? 'Sem código pessoal' : game.personalCode}</p>
      </div>
    </div>
  );
}
