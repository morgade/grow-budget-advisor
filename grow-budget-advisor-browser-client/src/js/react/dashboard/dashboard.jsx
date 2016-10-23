import React from 'react';
import { connect, dispatch } from 'react-redux'

import PageHeader from 'react-bootstrap/lib/PageHeader';
import Row from 'react-bootstrap/lib/Row';
import Col from 'react-bootstrap/lib/Col';
import Alert from 'react-bootstrap/lib/Alert';

import ChartJS from 'react-chartjs';


class Dashboard extends React.Component {
    
    render() {
        const weekLabels = [];// ["Week 1", "2", "3", "4", "5", "6", "7"],
        const budgetPlannedSeq = [];//[90, 90, 90, 90, 90, 90, 90];
        const realizedSeq = [];//[90, 90, 90, 90, 90, 90, 90];
        const weekRealized = this.props.budget.data.weekExpenses;
        for (var weekNumber in weekRealized) {
            if (weekRealized.hasOwnProperty(weekNumber)) {
                weekLabels.push(weekNumber.toString());
                budgetPlannedSeq.push(this.props.budget.data.weekIncomes[weekNumber.toString()]);
                realizedSeq.push(weekRealized[weekNumber.toString()]);
            }
        }
        
        if (weekLabels.length>0) {
            weekLabels[0] = "Week "+ weekLabels[0];
        }
        
        const chartDataBudgetRealized = {
            labels: weekLabels,
            datasets: [
                {
                    label: "Income",
                    fillColor: "rgba(120,220,120,0.1)",
                    strokeColor: "rgba(120,220,120,0.8)",
                    highlightFill: "rgba(120,220,120,0.75)",
                    highlightStroke: "rgba(120,220,120,1)",
                    data: budgetPlannedSeq
                },
                {
                    label: "Expenses",
                    fillColor: "rgba(251,187,205,0.5)",
                    strokeColor: "rgba(251,187,205,0.8)",
                    highlightFill: "rgba(251,187,205,0.75)",
                    highlightStroke: "rgba(251,187,205,1)",
                    data: realizedSeq
                }
            ]
        };
        var chartData2 = {
    labels: ["Week 1", "Week 2", "Week 3", "Week 4", "Week 5", "Week 6", "Week 7"],
    datasets: [
        {
            label: "Budget",
            fillColor: "rgba(120,220,120,0.1)",
            strokeColor: "rgba(120,220,120,0.8)",
            highlightFill: "rgba(120,220,120,0.75)",
            highlightStroke: "rgba(120,220,120,1)",
            data: [100, 100, 100, 100, 100, 100, 100]
        },
        {
            label: "Realized",
            fillColor: "rgba(101,107,205,0.5)",
            strokeColor: "rgba(101,107,205,0.8)",
            highlightFill: "rgba(101,107,205,0.75)",
            highlightStroke: "rgba(101,107,205,1)",
            data: [12, 28, 40, 45, 47, 56, 80]
        }
    ]
};

var chartOptions = {
        responsive: true,
        maintainAspectRatio: false,
        scales: {
            xAxes: [{
                stacked: true
            }],
            yAxes: [{
                stacked: true
            }]
        }
    };
        return (
                <div>
                    <PageHeader>Graphs'n Tips</PageHeader>
                    <Row>
                        <Col md={6}>
                        <b>Budget X Realized</b>
            <ChartJS.Line data={chartDataBudgetRealized} options={chartOptions} width="100" />
                          </Col>
                        <Col md={6}>
                        <b>'My new TV' Progress [2 weeks more to reach !]</b>
            <ChartJS.Line data={chartData2} options={chartOptions} width="100" />
                          </Col>
                    </Row>
                    <Row>
                        <Col md={12}>
                        <Alert bsStyle="warning">
                            <strong>Valuable Tip!</strong> Looks like a fair part of your budget is used to pay loan installments. 
                            Did you know that <a href="http://partnerpage.com">Bank X</a> has great interest rates ? Lowering loan installments in 10% would allow you to reach the 'New TV' goal <b>X weeks faster</b> !
                          </Alert>
                        </Col>
                    </Row>
                    <Row>
                        <Col md={6}>
                        <Alert bsStyle="success">
                            <strong>Good Job!</strong> You are spending with utilities bills less than what was foressen in your budget ! It's a good way to saving for your goals.
                            If you adjust your budget to what was realized, you will reach the 'New TV' <b>X weeks faster</b>
                          </Alert>
                          </Col>
                        <Col md={6}>
                        <Alert bsStyle="danger">
                        <strong>Taxes are inevitable ....</strong>  And your budget has been suffering with it. Did you know that investing in <a href="http://partnerpage.com">X invest</a> you can deduct taxes and save still more for your goals ? Give it a try !
                          </Alert>
                          </Col>
                    </Row>
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Dashboard);