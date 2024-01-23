import axios from "axios";
import { useEffect, useState } from "react";
import GameCard from "../../components/GameCard";
import { GameType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";

export default function GameCardList() {
  const [gamelist, setGamelist] = useState<GameType[]>([]);

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
