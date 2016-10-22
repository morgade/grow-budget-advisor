import React from 'react';
import { connect, dispatch } from 'react-redux'

import ReactCSSTransitionGroup from 'react-addons-css-transition-group';
import ListGroup from 'react-bootstrap/lib/ListGroup';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Button from 'react-bootstrap/lib/Button';
import Item from './item.jsx';
import ItemForm from './item-form.jsx';
import * as BudgetActions from '../../flux/actions/budget';

class Budget extends React.Component {
    
    componentDidMount() {
        if (this.props.budget.data.items.length===0) {
            this.props.dispatch(BudgetActions.fetchBudget(this.props.budget.account));
        }
    }
     

    render() {
        const items = this.props.budget.data.items.map( (item) => 
            <Item key={item.id} item={item} /> 
        );
        
        return (
            <div>
                <PageHeader>
                    <ItemForm />
                    My planned budget
                </PageHeader>

                <ListGroup>
                    {items}
                </ListGroup>

                
            </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Budget);