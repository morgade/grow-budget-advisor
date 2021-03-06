// 3rd party modules
import React from 'react';
import objectAssign from 'object-assign';
import { connect, dispatch } from 'react-redux'
import Form from 'react-bootstrap/lib/Form';
import FormGroup from 'react-bootstrap/lib/FormGroup';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import FormControl from 'react-bootstrap/lib/FormControl';
import Button from 'react-bootstrap/lib/Button';
import Modal from 'react-bootstrap/lib/Modal';

// project modules
import * as BudgetActions from '../../flux/actions/budget'

/**
 * A button / modal from to create budget iems
 */
class ItemForm extends React.Component {
    
    /**
     * Initialize state
     * @param {object} props
     */
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
        this.state = objectAssign({}, this.state, this.proccessCategories(props));
    }
    
    /**
     * Change state to close modal
     */
    close() {
        this.setState({ show: false });
    }

    /**
     * Change state to open modal
     */
    open() {
      this.setState({ show: true });
    }
    
    /**
     * Trigger changes of several state fiels.
     * Resets category state when changing the 'kind' 
     * @param {Event} evt
     * @param {string} field
     */
    onChange(evt, field) {
        var change = { [field]: evt.target.value };
        if (field==='kind') {
            change.category = evt.target.value === 'INCOME' ? this.state.incomes[0].id : this.state.expenses[0].id;
        }
        this.setState(change);
    }

    /**
     * Dispatches a budget creatioon request based on current state
     * TODO: Validate form data
     */
    confirm() {
      this.props.dispatch(BudgetActions.addBudgetItem(
                this.props.budget.account,
                {
                    amount: this.state.amount,
                    text: this.state.text,
                    category: { id: this.state.category }
                }
            )
        ).then( () => { 
            this.close();
            this.props.dispatch(BudgetActions.fetchBudget(this.props.budget.account));
        });
    }
    
    /**
     * trigger update categories
     * @param {object} newProps
     */
    componentWillReceiveProps(newProps) {
        this.setState(this.proccessCategories(newProps));
    }
    
    /**
     * update incomes/expenses lists com properties changing
     * @param {object} props
     */
    proccessCategories(props) {
        let categories = { incomes: [], expenses: [] };
        for (let i=0; i<props.budget.categories.length; i++) {
            if (props.budget.categories[i].income) {
                categories.incomes.push(props.budget.categories[i]);
            } else {
                categories.expenses.push(props.budget.categories[i]);
            }
        }
        categories.category = categories.incomes[0] ? categories.incomes[0].id : null;
        return categories;
    }
    
    /**
     * React render method
     */
    render() {
        const categories = this.state.kind === 'INCOME' ? this.state.incomes : this.state.expenses;
        const categoriesOptions = categories.map( (item) => 
            <option key={item.id} value={item.id}>{item.text}</option>
        );
        
        return (
            <div>
                <Button bsStyle="primary" className="pull-right" onClick={(evt)=>this.open()}>ADD ITEM</Button>
                <Modal show={this.state.show} onHide={this.close}>
                <Modal.Header>
                    <Modal.Title>Add Buget Item</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                        <Form onSubmit={(evt) => this.confirm()}>
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
                            <FormGroup controlId="category">
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
                              <Button bsStyle="danger" onClick={this.close.bind(this)}>Cancel</Button>
                              <Button bsStyle="primary" onClick={(evt) => this.confirm()}>Create</Button>
                    </Modal.Footer>
                </Modal>
            </div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(ItemForm);
