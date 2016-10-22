import React from 'react';
import { connect, dispatch } from 'react-redux'

import ListGroup from 'react-bootstrap/lib/ListGroup';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Item from './item.jsx';

class Goals extends React.Component {
    
    render() {
        const items = this.props.budget.goals.map( (goal) => 
                <Item key={goal.id} item={goal} /> 
            );
        
        return (
                <div>
                    <PageHeader>My Goals</PageHeader>
                        <ListGroup>
                            {items}
                        </ListGroup>
                    
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Goals);