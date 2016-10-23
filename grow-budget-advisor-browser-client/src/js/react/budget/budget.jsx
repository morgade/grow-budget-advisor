// 3rd party modules
import React from 'react';
import { connect, dispatch } from 'react-redux'
import ReactCSSTransitionGroup from 'react-addons-css-transition-group';
import ListGroup from 'react-bootstrap/lib/ListGroup';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Button from 'react-bootstrap/lib/Button';
import ListGroupItem from 'react-bootstrap/lib/ListGroupItem';
import Label from 'react-bootstrap/lib/Label';
import NumberFormat from 'react-number-format';

// project modules
import Item from './item.jsx';
import ItemForm from './item-form.jsx';
import * as BudgetActions from '../../flux/actions/budget';

/**
 * Budget list main component
 */
class Budget extends React.Component {
    /**
     * React render method
     */
    render() {
        let items = this.props.budget.data.items.map( (item) =>  
            <Item key={item.id} item={item} />  
        );

        items.push(
            <ListGroupItem key="_expected_balance"  bsStyle="info">
                Expected Balance:
                <Label bsStyle={this.props.budget.data.expectedBalance>0?"success":"danger"} className="pull-right full-font">
                    <NumberFormat value={this.props.budget.data.expectedBalance} displayType="text" thousandSeparator={true} prefix="$" />
                </Label>
            </ListGroupItem>
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
