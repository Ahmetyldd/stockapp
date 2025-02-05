import { createSlice, PayloadAction } from "@reduxjs/toolkit";

import { FullProductResponse, LoadingStatus, ReviewResponse } from "../../types/types";
import { fetchProduct, fetchProductByQuery, fetchReviewsByProductId } from "./perfume-thunks";

export interface ProductState {
    perfume: Partial<FullProductResponse>;
    reviews: Array<ReviewResponse>;
    errorMessage: string;
    loadingState: LoadingStatus;
}

export const initialState: ProductState = {
    perfume: {},
    reviews: [],
    errorMessage: "",
    loadingState: LoadingStatus.LOADING
};

export const perfumeSlice = createSlice({
    name: "perfume",
    initialState,
    reducers: {
        setProduct(state, action: PayloadAction<FullProductResponse>) {
            state.perfume = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        },
        setReview(state, action: PayloadAction<ReviewResponse>) {
            state.reviews = [...state.reviews, action.payload];
            state.loadingState = LoadingStatus.LOADED;
        },
        resetProductState: () => initialState
    },
    extraReducers: (builder) => {
        builder.addCase(fetchProduct.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProduct.fulfilled, (state, action) => {
            state.perfume = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProduct.rejected, (state, action) => {
            state.errorMessage = action.payload!;
            state.loadingState = LoadingStatus.ERROR;
        });
        builder.addCase(fetchReviewsByProductId.fulfilled, (state, action) => {
            state.reviews = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProductByQuery.pending, (state) => {
            state.loadingState = LoadingStatus.LOADING;
        });
        builder.addCase(fetchProductByQuery.fulfilled, (state, action) => {
            state.perfume = action.payload;
            state.loadingState = LoadingStatus.LOADED;
        });
        builder.addCase(fetchProductByQuery.rejected, (state, action) => {
            state.errorMessage = action.payload!;
            state.loadingState = LoadingStatus.ERROR;
        });
    }
});

export const { setProduct, setReview, resetProductState } = perfumeSlice.actions;
export default perfumeSlice.reducer;
