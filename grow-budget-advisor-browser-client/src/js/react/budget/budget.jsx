import React from 'react';
import { connect, dispatch } from 'react-redux'

import ReactCSSTransitionGroup from 'react-addons-css-transition-group';
import ListGroup from 'react-bootstrap/lib/ListGroup';
import PageHeader from 'react-bootstrap/lib/PageHeader';
import Button from 'react-bootstrap/lib/Button';
import Modal from 'react-bootstrap/lib/Modal';
import Item from './item.jsx';
import ItemForm from './item-form.jsx';
import * as BudgetActions from '../../flux/actions/budget';

class Budget extends React.Component {
    
    constructor(props) {
        super(props);
        this.state = {
            showItemModal: false
        };
    }
    
    componentDidMount() {
        if (this.props.budget.data.items.length===0) {
            this.props.dispatch(BudgetActions.fetchBudget(this.props.budget.account));
        }
    }
    
    close() {
        this.setState({ showItemModal: false });
    }

    open() {
      this.setState({ showItemModal: true });
    }
    
    render() {
        const items = this.props.budget.data.items.map( (item) => 
                <Item key={item.id} item={item} /> 
            );
        
        return (
                <div>
                    <PageHeader>
                        <Button bsStyle="primary" className="pull-right" onClick={(evt)=>this.open()}>ADD GOAL</Button>
                        My planned budget
                    </PageHeader>
                        
                    <ListGroup>
                        {items}
                    </ListGroup>
                    
                    <Modal show={this.state.showItemModal} onHide={this.close}>
                        <Modal.Header>
                          <Modal.Title>Add Buget Item</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <ItemForm />
                        </Modal.Body>
                        <Modal.Footer>
                          <Button onClick={(evt)=>this.close()}>Close</Button>
                        </Modal.Footer>
                      </Modal>
                </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Budget);