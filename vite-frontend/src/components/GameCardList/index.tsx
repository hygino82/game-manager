import axios from "axios";
import { useEffect, useState } from "react";
import { Game } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";
import GameCard from "../GameCard";

function GameCardList() {
  const [gamelist, setGamelist] = useState<Game[]>([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/game`).then((response) => {
      setGamelist(response.data.content);
    });
  }, []);

  return (
    <div>
      {gamelist.map((game) => {
        return <GameCard key={game.id} game={game} />;
      })}
    </div>
  );
}

export default GameCardList;
