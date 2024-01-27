import axios from "axios";
import moment from "moment";
import { useEffect, useState } from "react";
import { FiEdit } from "react-icons/fi";
import { Link, useParams } from "react-router-dom";
import { ConsoleType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";
import './styles.css';

export default function ConsoleCardInfo(): JSX.Element {
  const { id } = useParams();

  const [consoleType, setConsoleType] = useState<ConsoleType>({
    id: '',
    name: '',
    imgUrl: '',
    createdAt: '',
    updatedAt: '',
    releaseYear: 0
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/console/${id}`).then((response) => {
      setConsoleType(response.data);
    });

  }, []);
  return (
    <div className="card" id="console-card" key={consoleType.id}>
      <div className="card-body">
        <h5 className="card-title">{consoleType.name}</h5>
        <p className="card-text">{consoleType.releaseYear}</p>
        <div>
          <p className="card-text">
            Adicionado
          </p>
          {moment(consoleType.createdAt).format('DD/MM/yyyy hh:mm:ss')}
        </div>

        <div>
          {consoleType.updatedAt ? (
            <>
              <p className="card-text">Alterado</p>
              {moment(consoleType.updatedAt).format('DD/MM/yyyy hh:mm:ss')}
            </>
          ) : (
            null
          )}
        </div>

      </div>
      <img className="card-img-top" src={consoleType.imgUrl} alt="" />
      <Link to={`/edit/console/${id}`} className="btn btn-warning" ><FiEdit /></Link>
    </div>
  );
}
