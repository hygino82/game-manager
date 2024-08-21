import axios from "axios";
import { useEffect, useState } from "react";
import { FiEdit, FiInfo, FiTrash2 } from "react-icons/fi";
import { ConsolePageType } from "../../types/custom-types";
import { BASE_URL } from "../../utils/request";

function ConsoleTable() {

    const [pageNumber, setPageNumber] = useState(0);

    const [page, setPage] = useState<ConsolePageType>({
        content: [],
        last: true,
        totalPages: 0,
        totalElements: 0,
        size: 15,
        number: 0,
        first: true,
        numberOfElements: 0,
        empty: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/console?size=15&page=${pageNumber}`)
            .then(response => {
                const data = response.data as ConsolePageType;
                setPage(data);
            });
    }, [pageNumber]);

    const handlePageChange = (newPageNumber: number) => {
        setPageNumber(newPageNumber);
    }

    return (
        <table className="table table-striped">
            <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Name</th>
                    <th scope="col">Release date</th>
                    <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody>
                {page.content.map(obj => (
                    <tr key={obj.id}>
                        <th scope="col">{obj.id}</th>
                        <th scope="col">{obj.name}</th>
                        <th scope="col">{obj.releaseDate}</th>
                        <th scope="col"> <FiInfo /> <FiEdit /> <FiTrash2 /></th>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export default ConsoleTable;