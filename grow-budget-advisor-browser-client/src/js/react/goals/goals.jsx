import React from 'react';
import { connect, dispatch } from 'react-redux'

import Button from 'react-bootstrap/lib/Button';
import ListGroup from 'react-bootstrap/lib/ListGroup';
import Modal from 'react-bootstrap/lib/Modal';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Item from './item.jsx';
import GoalForm from './goal-form.jsx';

class Goals extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            showItemModal: false
        };
    }
    
    close() {
        this.setState({ showItemModal: false });
    }

    open() {
      this.setState({ showItemModal: true });
    }
    
    render() {
        const items = this.props.budget.data.goals.map( (goal) => 
                <Item key={goal.id} item={goal} /> 
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