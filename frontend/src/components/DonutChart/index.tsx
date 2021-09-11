import axios from 'axios';
import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts'
import { BASE_URL } from 'utils/request';
type ChartData = {
    labels : string[];
    series : number[];
}
const DonutChart = () => {

    const [chartData, setChartData] = useState<ChartData>({labels : [], series : []});
    useEffect(() => {

        axios.get(`${BASE_URL}/sale/totalSales`)
        .then(response => {
            
            let myLabels = [];
            let mySeries = [];
            for (let key in response.data) {

                myLabels.push(response.data[key][0]);
                mySeries.push(Math.round(response.data[key][1]*10)/10);

            }
            setChartData({labels : myLabels, series : mySeries})
            
            }
        )
    },[]);

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