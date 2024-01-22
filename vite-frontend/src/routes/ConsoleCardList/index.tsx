import axios from "axios";
import { useEffect, useState } from "react";
import ConsoleCard from "../../components/ConsoleCard";
import { ConsoleType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";

export default function ConsoleCardList() {
  const [consoleList, setConsoleList] = useState<ConsoleType[]>([]);

  useEffect(() => {
    axios.get(`${BASE_URL}/console`).then((response) => {
      setConsoleList(response.data.content);
    });
  }, []);

  return (
    <div>
      {consoleList.map((consoleType) => {
        return <ConsoleCard key={consoleType.id} consoleType={consoleType} />;
      })}
    </div>
  );

}
