import React, { Component } from 'react'
import Chart from 'react-apexcharts'
import axios from 'axios'

const api = axios.create(
    {
        baseURL: 'https://dsvendas-andrelsm.herokuapp.com/sale/taxSales'
    }
)

class BarChart extends React.Component {
  state= {
    options : {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    },
    
    mockData : {
    labels: {
        categories: ['Andre', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    },
    series: [
        {
            name: "% Sucesso",
            data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
        }
    ]
}
  };
    
    constructor(props: any) {
        super(props);
        const state= {
            options : {
                plotOptions: {
                    bar: {
                        horizontal: true,
                    }
                },
            },
            
            mockData : {
            labels: {
                categories: ['Andre', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
            },
            series: [
                {
                    name: "% Sucesso",
                    data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
                }
            ]
        }
          };
    }

    componentDidMount(){
        api.get('https://dsvendas-andrelsm.herokuapp.com/sale/taxSales')
        .then(response => {
            console.log(response)
            const categories: string[] = [];
            const data: BigInteger[] = [];
            for (let key in response.data) {

                categories.push(response.data[key][0]);
                data.push(response.data[key][1]);

            }
            this.setState({'mockData.labels.categories' : categories}) 

        });
    }
    render() {
        return (
            <Chart 
            options={{...this.state.options, xaxis:this.state.mockData.labels}}
            series={this.state.mockData.series}
            type="bar"
            height="240"
        />
        )
    }
}
/*const BarChart = () => {
    const options = {
        plotOptions: {
            bar: {
                horizontal: true,
            }
        },
    };
    
    const mockData = {
    labels: {
        categories: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    },
    series: [
        {
            name: "% Sucesso",
            data: [43.6, 67.1, 67.7, 45.6, 71.1]                   
        }
    ]
};

    axios.get('https://dsvendas-andrelsm.herokuapp.com/sale/taxSales')
    .then(response => {
        console.log(response)
        const categories : string[] = [];
        const data : BigInteger[] = [];
        for(let key in response.data){
           
            categories.push(response.data[key][0]);
            data.push(response.data[key][1]);

        }

        mockData.labels = {categories};
        
    } );
    return (
        <Chart 
            options={{...options, xaxis:mockData.labels}}
            series={mockData.series}
            type="bar"
            height="240"
        />
    );
}*/

export default BarChart;