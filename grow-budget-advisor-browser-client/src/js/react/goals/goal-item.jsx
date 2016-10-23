// 3rd party modules
import React from 'react';
import { connect, dispatch } from 'react-redux'
import NumberFormat from 'react-number-format';
import ListGroupItem from 'react-bootstrap/lib/ListGroupItem';

// project modules
import Label from 'react-bootstrap/lib/Label';

/**
 * A simple goal item listgrougitem
 */
class GoalItem extends React.Component {
    /**
     * React render method
     */
    render() {
        return (
            <ListGroupItem>
                {this.props.item.text}
                <Label bsStyle="info" className="pull-right full-font">
                    <NumberFormat value={this.props.item.amount} displayType="text" thousandSeparator={true} prefix="$" />
                </Label>
            </ListGroupItem>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(GoalItem);