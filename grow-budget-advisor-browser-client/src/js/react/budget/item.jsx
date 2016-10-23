import React from 'react';
import { connect, dispatch } from 'react-redux'
import NumberFormat from 'react-number-format';

import ListGroupItem from 'react-bootstrap/lib/ListGroupItem';
import Label from 'react-bootstrap/lib/Label';

class Item extends React.Component {

    render() {
        return (
            <ListGroupItem header={this.props.item.text}>
                {this.props.item.category.text}
                <Label bsStyle={this.props.item.category.income?"success":"danger"} className="pull-right full-font">
                    <NumberFormat value={this.props.item.amount} displayType="text" thousandSeparator={true} prefix="$" />
                </Label>
            </ListGroupItem>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Item);
