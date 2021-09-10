import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import axios from 'axios'
import { BASE_URL } from 'utils/request';

type ChartData = {
    labels: {
        categories: string[];
    }
    series: [{ name: string, data: number[] }];
}
const BarChart = () => {

    const [chartData, setChartData] = useState<ChartData>({ labels: { categories: [] }, series: [{ name: "", data: [] }] });
    useEffect(() => {

        axios.get(`${BASE_URL}/sale/taxSales`)
            .then(response => {

                let myCategories = [];
                let myData = [];
                for (let key in response.data) {

                    myCategories.push(response.data[key][0]);
                    myData.push(Math.round(response.data[key][1]*10)/10);

                }
                setChartData({ labels: { categories: myCategories }, series: [{ name: "% Sucesso", data: myData }] })
            }
            )
    }, []);
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    return (
        <Chart
            options={{ ...options, xaxis: chartData.labels }}
            series={chartData.series}
            type="bar"
            height="240"
        />
    );
}

export default BarChart;