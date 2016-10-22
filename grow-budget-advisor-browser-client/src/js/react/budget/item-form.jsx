import React from 'react';
import { connect, dispatch } from 'react-redux'

import Form from 'react-bootstrap/lib/Form';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import FormControl from 'react-bootstrap/lib/FormControl';
import Button from 'react-bootstrap/lib/Button';
import Modal from 'react-bootstrap/lib/Modal';

import * as BudgetActions from '../../flux/actions/budget'

class ItemForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            kind: 'INCOME',
            show: false,
            amount: '0',
            category: "",
            text: '',
            incomes: [ ],
            expenses: [ ]
        };
    }
    
    close() {
        this.setState({ show: false });
    }

    open() {
      this.setState({ show: true });
    }
    
    onChange(evt, field) {
        this.setState({ [field]: evt.target.value });
    }

    confirm() {
      this.props.dispatch(BudgetActions.addBudgetItem(
                this.props.budget.account,
                {
                    amount: this.state.amount,
                    text: this.state.text,
                    category: this.state.category
                }
            )
        );
    }
    
    componentWillReceiveProps(newProps) {
        let categories = { incomes: [], expenses: [], category: newProps.budget.categories[0].id };
        for (let i=0; i<newProps.budget.categories.length; i++) {
            if (newProps.budget.categories[i].income) {
                categories.incomes.push(newProps.budget.categories[i]);
            } else {
                categories.expenses.push(newProps.budget.categories[i]);
            }
        }
        
        this.setState(categories);
    }
    
    componentDidMount() {
        this.props.dispatch(BudgetActions.fetchCategories());
    }
    
    render() {
        const categories = this.state.kind === 'INCOME' ? this.state.incomes : this.state.expenses;
        const categoriesOptions = categories.map( (item) => 
            <option value={item.id}>{item.text}</option>
        );
        
        return (
            <div>
                <Button bsStyle="primary" className="pull-right" onClick={(evt)=>this.open()}>ADD BUDGET</Button>
                <Modal show={this.state.show} onHide={this.close}>
                <Modal.Header>
                    <Modal.Title>Add Buget Item</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                        <Form onSubmit={this.login}>
                            <FormGroup controlId="kind">
                                <ControlLabel>This item describes an expected</ControlLabel>
                                <FormControl componentClass="select" value={this.state.kind} onChange={(evt) => this.onChange(evt, 'kind') }>
                                    <option value="INCOME">INCOME</option>
                                    <option value="EXPENSE">EXPENSE</option>
                                </FormControl>
                            </FormGroup>
                            <FormGroup controlId="text">
                                <ControlLabel>Describe your budget item</ControlLabel>
                                <FormControl type="text" placeholder="Item description" onChange={(evt) => this.onChange(evt, 'text') } />
                            </FormGroup>
                            <FormGroup controlId="text">
                                <ControlLabel>Choose a category that best fits your budget item</ControlLabel>
                                <FormControl value={this.state.category} componentClass="select" placeholder="select" onChange={(evt) => this.onChange(evt, 'category') } >
                                    {categoriesOptions} 
                                </FormControl>
                            </FormGroup>
                            <FormGroup controlId="password">
                                <ControlLabel>Amount ($)</ControlLabel>
                                <FormControl type="text" placeholder="Weekly amount expected for this item" onChange={(evt) => this.onChange(evt, 'amount') }/>
                            </FormGroup>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                              <Button bsStyle="danger" onClick={(evt) => this.close()}>Cancel</Button>
                              <Button bsStyle="primary" onClick={(evt) => this.confirm()}>Create</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(ItemForm);