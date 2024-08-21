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
    <div className="card" id="console-card-info">
      <img
        className="card-img-top"
        src={obj.imageUrl}
        onError={(e) => (e.currentTarget.src = semImagem)}
      />
      <div className="card-body">
        <h3>Nome: {obj.name}</h3>
        <br />
        <p>Empresa: {obj.company}</p>
        <br />
        <p>Data de lançamento: {formatDate(obj.releaseDate)}</p>
        <br />
        <p>Adicionado em:</p>
        <p>{obj.createAt}</p>
        {obj.updateAt ? (
          <div>
            <p>Modificado em:</p>
            <p>{obj.updateAt}</p>
          </div>
        ) : null}
        <br />
      </div>
    </div>
  );
}
