import axios from 'axios';
import Chart from 'react-apexcharts'
import { BASE_URL } from 'utils/request';
type ChartDate = {
    labels : string[];
    series : number[];
}
const DonutChart = () => {
    let chartData : ChartDate = {labels : [], series : []};

    axios.get(`${BASE_URL}/sale/totalSales`)
        .then(response => {
            console.log(response);
           
            for (let key in response.data) {

                chartData.labels.push(response.data[key][0]);
                chartData.series.push(response.data[key][1]);

            }
            console.log(chartData);
            }
        )

    const mockData = {
        series: [477138, 499928, 444867, 220426, 473088],
        labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    }
    
    const options = {
        legend: {
            show: true
        }
    }
    return (
        <Chart 
            options={{...options, labels:chartData.labels}}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;