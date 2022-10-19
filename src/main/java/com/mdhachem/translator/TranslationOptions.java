package com.mdhachem.translator;

import java.util.Collection;

/**
 * 
 * @author Mohamed Dhia Hachem
 * @email mdhachem@outlook.fr
 *
 */
public class TranslationOptions {

	private final Formality formality;
	private final String glossaryId;
	private final SentenceSplittingMode sentenceSplittingMode;
	private final boolean preserveFormatting;
	private final String tagHandling;
	private final boolean outlineDetection;
	private final Iterable<String> ignoreTags;
	private final Iterable<String> nonSplittingTags;
	private final Iterable<String> splittingTags;

	public TranslationOptions(Formality formality, String glossaryId, SentenceSplittingMode sentenceSplittingMode,
			boolean preserveFormatting, String tagHandling, boolean outlineDetection, Iterable<String> ignoreTags,
			Iterable<String> nonSplittingTags, Iterable<String> splittingTags) {
		super();
		this.formality = formality;
		this.glossaryId = glossaryId;
		this.sentenceSplittingMode = sentenceSplittingMode;
		this.preserveFormatting = preserveFormatting;
		this.tagHandling = tagHandling;
		this.outlineDetection = outlineDetection;
		this.ignoreTags = ignoreTags;
		this.nonSplittingTags = nonSplittingTags;
		this.splittingTags = splittingTags;
	}

	public Formality getFormality() {
		return formality;
	}

	public String getGlossaryId() {
		return glossaryId;
	}

	public SentenceSplittingMode getSentenceSplittingMode() {
		return sentenceSplittingMode;
	}

	public boolean isPreserveFormatting() {
		return preserveFormatting;
	}

	public String getTagHandling() {
		return tagHandling;
	}

	public boolean isOutlineDetection() {
		return outlineDetection;
	}

	public Iterable<String> getIgnoreTags() {
		return ignoreTags;
	}

	public Iterable<String> getNonSplittingTags() {
		return nonSplittingTags;
	}

	public Iterable<String> getSplittingTags() {
		return splittingTags;
	}

	public static class Builder {

		private Formality formality;
		private String glossaryId;
		private SentenceSplittingMode sentenceSplittingMode;
		private boolean preserveFormatting;
		private String tagHandling;
		private boolean outlineDetection;
		private Collection<String> ignoreTags;
		private Collection<String> nonSplittingTags;
		private Collection<String> splittingTags;

		public Builder() {
			preserveFormatting = false;
			outlineDetection = true;
		}

		public Builder setFormality(Formality formality) {
			this.formality = formality;
			return this;
		}

		public Builder setGlossaryId(String glossaryId) {
			this.glossaryId = glossaryId;
			return this;
		}

		public Builder setSentenceSplittingMode(SentenceSplittingMode sentenceSplittingMode) {
			this.sentenceSplittingMode = sentenceSplittingMode;
			return this;
		}

		public Builder setPreserveFormatting(boolean preserveFormatting) {
			this.preserveFormatting = preserveFormatting;
			return this;
		}

		public Builder setTagHandling(String tagHandling) {
			this.tagHandling = tagHandling;
			return this;
		}

		public Builder setOutlineDetection(boolean outlineDetection) {
			this.outlineDetection = outlineDetection;
			return this;
		}

		public Builder setIgnoreTags(Collection<String> ignoreTags) {
			this.ignoreTags = ignoreTags;
			return this;
		}

		public Builder setNonSplittingTags(Collection<String> nonSplittingTags) {
			this.nonSplittingTags = nonSplittingTags;
			return this;
		}

		public Builder setSplittingTags(Collection<String> splittingTags) {
			this.splittingTags = splittingTags;
			return this;
		}

		public TranslationOptions build() {
			return new TranslationOptions(formality, glossaryId, sentenceSplittingMode, preserveFormatting, tagHandling,
					outlineDetection, ignoreTags, nonSplittingTags, splittingTags);
		}

	}

}
