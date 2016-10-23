import React from 'react';
import { connect, dispatch } from 'react-redux'

import PageHeader from 'react-bootstrap/lib/PageHeader';
import Row from 'react-bootstrap/lib/Row';
import Col from 'react-bootstrap/lib/Col';
import Alert from 'react-bootstrap/lib/Alert';
import DropdownButton from 'react-bootstrap/lib/DropdownButton';
import MenuItem from 'react-bootstrap/lib/MenuItem';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';

import ChartJS from 'react-chartjs';


class Dashboard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            selectedGoal: null
        };
    }
    
    getGoal(id) {
        let goals = this.props.budget.data.goals;
        for (let i=0; i<goals.length; i++) {
            if (goals[i].id===id) {
                return goals[i];
            }
        }
        return null;
    }
    
    selectGoal(id) {
        let goal = this.getGoal(id);
        this.setState({
            selectedGoal: goal
        });
    }
    
    render() {
        let selectedGoal = this.state.selectedGoal;
        if (selectedGoal===null) {
            selectedGoal = this.props.budget.data.goals.length>0 ?
                                    this.props.budget.data.goals[0]
                                    :
                                    { id:null, text: 'No goals found' };
            
        }
        
        const weeksNumbers = (container) => {
            var weeks = [];
            for (var weekNumber in weekRealized) {
                if (weekRealized.hasOwnProperty(weekNumber)) {
                    weeks.push(parseInt(weekNumber));
                }
            }
            return weeks.sort( (a,b) => a-b );
        };
        
        const realizedWeekLabels = [];
        const budgetPlannedSeq = [];
        const realizedSeq = [];
        const weekRealized = this.props.budget.data.weekExpenses;
        const weeks = weeksNumbers(weekRealized);
        
        for (let i=0; i<weeks.length; i++) {
            if (weekRealized.hasOwnProperty(weeks[i])) {
                realizedWeekLabels.push(weeks[i].toString());
                budgetPlannedSeq.push(this.props.budget.data.weekIncomes[weeks[i].toString()]);
                realizedSeq.push(weekRealized[weeks[i].toString()]);
            }
        }
        
        if (realizedWeekLabels.length>0) {
            realizedWeekLabels[0] = "Week "+ realizedWeekLabels[0];
        }
        
        let goalProgressDatasets = {};
        let goalAmountDatasets = {};
        let goalProgress = this.props.budget.data.goalProgress;
        for (let id in goalProgress) {
            if (goalProgress.hasOwnProperty(id)) {
                let goal = this.getGoal(id);
                goalProgressDatasets[id] = [];
                goalAmountDatasets[id] = [];
                const weeks = weeksNumbers(goalProgress[id]);
                for (let i=0; i<weeks.length; i++) {
                    if (goalProgress[id].hasOwnProperty(weeks[i])) {
                        goalProgressDatasets[id].push(goalProgress[id][weeks[i]]);
                        goalAmountDatasets[id].push(goal.amount);
                    }
                }
            }
        }
        
        
        
        const chartDataBudgetRealized = {
            labels: realizedWeekLabels,
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
            data: goalAmountDatasets[selectedGoal.id]//[100, 100, 100, 100, 100, 100, 100]
        },
        {
            label: "Realized",
            fillColor: "rgba(101,107,205,0.5)",
            strokeColor: "rgba(101,107,205,0.8)",
            highlightFill: "rgba(101,107,205,0.75)",
            highlightStroke: "rgba(101,107,205,1)",
            data: goalProgressDatasets[selectedGoal.id]//[12, 28, 40, 45, 47, 56, 80]
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
    
    let goaldropdownOptions = this.props.budget.data.goals.map(goal => (
        <MenuItem eventKey={goal.id} key={goal.id}>{goal.text}</MenuItem>
    ));
    
        return (
                <div>
                    <PageHeader>Charts'n Tips</PageHeader>
                    <Row>
                        <Col md={6}>
                        <ControlLabel>Income X Expense</ControlLabel>
                            <ChartJS.Line data={chartDataBudgetRealized} options={chartOptions} width="100" />
                          </Col>
                        <Col md={6}>
                        <b>Goal Progress: </b>
                        <DropdownButton title={selectedGoal.text} id="bgoal-dropdown" onSelect={(eventKey, evt) => this.selectGoal(eventKey)}>
                            {goaldropdownOptions}
                        </DropdownButton>
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