import axios from "axios";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import semImagem from "../../sem-imagem.svg";
import { ConsoleType } from "../../types/custom-types";
import { formatDate } from "../../utils/formatter";
import { BASE_URL } from "../../utils/request";
import "./style.css";

export function ConsoleInfo() {
  const { id } = useParams();
  const [obj, setObj] = useState<ConsoleType>({
    company: "",
    name: "",
    releaseDate: "",
    id: "",
    imageUrl: "",
    createAt: "",
    updateAt: "",
  });

  function buscarPorId(id: string | undefined) {
    axios.get(`${BASE_URL}/console/${id}`).then((result) => {
      setObj(result.data);
    });
  }

  useEffect(() => buscarPorId(id));

  return (
    <div className="container" id="console-card-info">
      <h3>Nome: {obj.name}</h3>
      <br />
      <p>Empresa: {obj.company}</p>
      <br />
      <p>Data de lançamento: {formatDate(obj.releaseDate)}</p>
      <br />
      <p>Adicionado em: {obj.createAt}</p>
      {obj.updateAt ? <p>Modificado em: {obj.updateAt}</p> : ""}
      <br />
      <img
        src={obj.imageUrl}
        onError={(e) => (e.currentTarget.src = semImagem)}
      />
    </div>
  );
}
