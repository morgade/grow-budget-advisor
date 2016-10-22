import React from 'react';
import { connect, dispatch } from 'react-redux'

import ReactCSSTransitionGroup from 'react-addons-css-transition-group';
import ListGroup from 'react-bootstrap/lib/ListGroup';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Item from './item.jsx';
import BudgetActions from '../../flux/actions/budget';

class Budget extends React.Component {
    
    componentDidMount() {
        if (this.props.budget.length===0) {
            this.props.dispatch();
        }
    }
    
    render() {
        const items = this.props.budget.items.map( (item) => 
                <Item key={item.id} item={item} /> 
            );
        
        return (
                <div>
                    <PageHeader>My planned budget</PageHeader>
                        <ListGroup>
                            {items}
                        </ListGroup>
                    
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Budget);