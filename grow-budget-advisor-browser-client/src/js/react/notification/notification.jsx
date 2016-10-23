// 3rd party modules
import React from 'react';
import {connect} from 'react-redux';
import NotificationSystem from 'react-notification-system';

/**
 * A simple notification component
 */
class Notification extends React.Component {
    /**
     *  Trigger a notification on update
     */
    componentDidUpdate() {
        if (this.props.notification) {
            this.notificationSystem.addNotification(this.props.notification);
        }
    }
    
    /**
     * Assign notification system
     */
    componentDidMount() {
        this.notificationSystem = this.refs.notificationSystem;
    }
    
    /**
     * React render method
     */
    render() {
        return (
            <NotificationSystem ref="notificationSystem" />
        );
    }
};

export default connect( state => ({notification: state.notification}) )(Notification);