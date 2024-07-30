// src/components/ErrorBoundary.js

import React, { Component } from "react";
import axios from "axios";

class ErrorBoundary extends Component {
  constructor(props) {
    super(props);
    this.state = { hasError: false, error: null, errorInfo: null };
  }

  static getDerivedStateFromError(error) {
    // Update state so the next render will show the fallback UI.
    return { hasError: true, error: error };
  }

  componentDidCatch(error, errorInfo) {
    // Catch errors in any components below and re-render with error message
    this.setState({ error: error, errorInfo: errorInfo });

    // Log error to the server
    this.logErrorToServer(error, errorInfo);
  }

  logErrorToServer(error, errorInfo) {
    const logRequest = {
      message: error.toString(),
      source: errorInfo.componentStack,
      userAgent: navigator.userAgent,
      url: window.location.href,
      timestamp: new Date().toISOString(),
    };

    axios.post('/sample/log', logRequest)
      .then(response => {
        console.log('Error logged to server:', response);
      })
      .catch(err => {
        console.error('Failed to log error to server:', err);
      });
  }

  render() {
    if (this.state.hasError) {
      // You can render any custom fallback UI
      return <h1>Something went wrong.</h1>;
    }

    return this.props.children; 
  }
}

export default ErrorBoundary;
