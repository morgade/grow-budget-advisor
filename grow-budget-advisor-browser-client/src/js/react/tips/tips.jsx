import React from 'react';
import { connect, dispatch } from 'react-redux'


class Tips extends React.Component {

    render() {
        return (
                <div>tips</div>
        );
    }

};

export default connect( state => ({ budget: state.budget }))(Tips);