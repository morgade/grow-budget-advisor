// 3rd party modules
import React from 'react';
import { connect, dispatch } from 'react-redux'
import Button from 'react-bootstrap/lib/Button';
import ListGroup from 'react-bootstrap/lib/ListGroup';
import Modal from 'react-bootstrap/lib/Modal';
import PageHeader from 'react-bootstrap/lib/PageHeader';
// project modules
import GoalItem from './goal-item.jsx';
import GoalForm from './goal-form.jsx';

/**
 * The Goals main component
 */
class Goals extends React.Component {
    /***
     * React render method
     */
    render() {
        const items = this.props.budget.data.goals.map( (goal) => 
                <GoalItem key={goal.id} item={goal} /> 
            );
        
        return (
                <div>
                    <PageHeader>
                        <GoalForm />
                        My Goals
                    </PageHeader>
                    
                    <ListGroup>
                        {items}
                    </ListGroup>
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Goals);