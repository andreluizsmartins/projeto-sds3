import axios from "axios";
import { useEffect, useState } from "react";
import { salePage } from "types/sale";
import { isTemplateExpression } from "typescript";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/request";

const DataTable = () => {

    const [page, setPage] = useState<salePage>({
        first: true,
        number : 0,
        totalElements: 0,
        totalPages:0,
        last: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sale/page?page=0&size=30$sort=date,desc`)
        .then(response => {
            
            setPage(response.data);
            
            }
        )
    },[])
    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    { page.content?.map(x => (
                        <tr>
                        <td>{formatLocalDate( x.date, "dd/MM/yyyy")}</td>
                        <td>{x.seller.name}</td>
                        <td>{x.visited}</td>
                        <td>{x.deals}</td>
                        <td>{x.amount.toFixed(2)}</td>
                        </tr>
                    ))
                   
                    }
                    
                </tbody>
            </table>
        </div>
    );
}

export default DataTable;
